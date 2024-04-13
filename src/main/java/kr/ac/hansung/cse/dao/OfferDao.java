package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
 * 필요 라이브러리 -> pom.xml
 * => jdbc class : spring-jdbc
 * => jdbc driver : mysql-connector-java
 * => data source : commons-dbcp2
 * */
@Repository
public class OfferDao {
    // DB 접근 방법에는 3가지 있음: JDBC < Hibernate(JPA 구현체), JPA(인터페이스) < Spring Data JPA
    // 2,3번을 주로 사용할 예정.
    // 여기서는 JDBC로 접근.

    private JdbcTemplate jdbcTemplate; // psa(portable service abstraction, sql(x) api를 통해 접근 가능

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public int getRowCount(){
        String sqlStatement = "select count(*) from offers";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    // query and return a single object
    public Offer getOffer(String name){
        String sqlStatement = "select * from offers where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<Offer>() {
                    @Override
                    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException{
                        Offer offer=new Offer();

                        offer.setId(rs.getInt("id"));
                        offer.setName(rs.getString("name"));
                        offer.setEmail(rs.getString("email"));
                        offer.setText(rs.getString("text"));

                        return offer;
                    }
                });
    }

    //query and return multiple objects
    // cRud Method
    public List<Offer> getOffers() {
        String sqlStatement = "select * from offers";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Offer>() {
            @Override
            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();

                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setEmail(rs.getString("email"));
                offer.setText(rs.getString("text"));

                return offer;
            }
        });
    }

    // Crud Method
    public boolean insert(Offer offer){
        String name=offer.getName();
        String email=offer.getEmail();
        String text=offer.getText();

        String sqlStatement="insert into offers (name,email,text) value (?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {name,email,text}) == 1);
    }

    // crUd Method
    public boolean update(Offer offer){
        int id=offer.getId();
        String name=offer.getName();
        String email=offer.getEmail();
        String text=offer.getText();

        String sqlStatement = "update offers set name=?, email=?, text=? where id=?";

        return (jdbcTemplate.update(sqlStatement, new Object[] {name,email,text,id}) == 1);
    }

    // cruD method
    public boolean delete(int id){
        String sqlStatement = "delete from offers where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
    }
}
