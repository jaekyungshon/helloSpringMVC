package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.HomeworkCourses;
import kr.ac.hansung.cse.model.HomeworkRegist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HomeworkDao {
    private JdbcTemplate jdbcTemplate; // psa(portable service abstraction, sql(x) api를 통해 접근 가능

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    // 검색 함수 : courses의 전체 레코드 가져오기
    public List<HomeworkCourses> getAllCoursesRecords(){
        String sqlStatement = "select * from courses";

        return jdbcTemplate.query(sqlStatement, new RowMapper<HomeworkCourses>() {
            @Override
            public HomeworkCourses mapRow(ResultSet rs, int rowNum) throws SQLException {
                HomeworkCourses course = new HomeworkCourses();

                course.setId(rs.getInt("id"));
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCode(rs.getString("code"));
                course.setName(rs.getString("name"));
                course.setClassification(rs.getString("classification"));
                course.setProfessor(rs.getString("professor"));
                course.setCredit(rs.getInt("credit"));

                return course;
            }
        });
    }

    // 검색 함수 : courses의 year, semester 컬럼 조건에 해당되는 레코드들 가져오기
    public List<HomeworkCourses> getYearSemesterCoursesRecords(int year, int semester){
        String sqlStatement = "select * from courses where year=? and semester=?";
        return jdbcTemplate.query(sqlStatement, new Object[]{year, semester}, new RowMapper<HomeworkCourses>() {
            @Override
            public HomeworkCourses mapRow(ResultSet rs, int rowNum) throws SQLException {
                HomeworkCourses course = new HomeworkCourses();

                course.setId(rs.getInt("id"));
                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCode(rs.getString("code"));
                course.setName(rs.getString("name"));
                course.setClassification(rs.getString("classification"));
                course.setProfessor(rs.getString("professor"));
                course.setCredit(rs.getInt("credit"));

                return course;
            }
        });
    }

    // 삽입 함수 : registration 테이블에 HomeworkRegist 레코드 삽입
    public boolean insert(HomeworkRegist homeworkRegist){
        String year = homeworkRegist.getYear();
        String semester = homeworkRegist.getSemester();
        String name = homeworkRegist.getName();
        String classification = homeworkRegist.getClassification();
        String professor = homeworkRegist.getProfessor();
        String credit = homeworkRegist.getCredit();

        String sqlStatement = "insert into registration (year,semester,name,classification,professor,credit) value (?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year,semester,name,classification,professor,credit}) == 1);
    }

    // 검색 함수 : registration 테이블 전체 레코드 가져오기
    public List<HomeworkRegist> getAllRegistration() {
        String sqlStatement = "select * from registration";

        return jdbcTemplate.query(sqlStatement, new RowMapper<HomeworkRegist>() {
            @Override
            public HomeworkRegist mapRow(ResultSet rs, int rowNum) throws SQLException {
                HomeworkRegist regist = new HomeworkRegist();

                regist.setId(rs.getInt("id"));
                regist.setYear(rs.getString("year"));
                regist.setSemester(rs.getString("semester"));
                regist.setName(rs.getString("name"));
                regist.setClassification(rs.getString("classification"));
                regist.setProfessor(rs.getString("professor"));
                regist.setCredit(rs.getString("credit"));

                return regist;
            }
        });
    }
}
