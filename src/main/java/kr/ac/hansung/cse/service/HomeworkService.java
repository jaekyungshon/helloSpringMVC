package kr.ac.hansung.cse.service;

/* Homework 학사 정보 시스템 서비스 클래스 */

import kr.ac.hansung.cse.dao.HomeworkDao;
import kr.ac.hansung.cse.model.HomeworkCourses;
import kr.ac.hansung.cse.model.HomeworkRegist;
import kr.ac.hansung.cse.model.HomeworkTotalCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeworkService {
    @Autowired
    private HomeworkDao homeworkDao;

    // menu1 : '학기별 이수 총 학점' 전체 테이블 원소를 담는 List 리턴.
    // 로직 : courses 테이블의 전체 레코드를 가져와, List<HomeworkTotalCredit>에 담기.
    public List<HomeworkTotalCredit> getAllTotalCredit() {
        List<HomeworkCourses> records = homeworkDao.getAllCoursesRecords(); // 전체 레코드
        //System.out.println("######## records size: "+records.size());
        List<HomeworkTotalCredit> result = new ArrayList<>(); // 리턴 대상

        // courses 레코드들 하나씩 순회
        for(HomeworkCourses record : records){
            int year = record.getYear(); // 년도
            int semester = record.getSemester(); // 학기
            int credit = record.getCredit(); // 학점

            if(result.isEmpty()){
                HomeworkTotalCredit item = new HomeworkTotalCredit();
                item.setYear(year);
                item.setSemester(semester);
                item.setTotalCredit(credit);
                result.add(item);
            }
            else{
                boolean flag=false;
                for (HomeworkTotalCredit item : result) {
                    if (item.getYear() == year && item.getSemester() == semester) {
                        item.sumTotalCredit(credit);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    HomeworkTotalCredit item = new HomeworkTotalCredit();
                    item.setYear(year);
                    item.setSemester(semester);
                    item.setTotalCredit(credit);
                    result.add(item);
                }
            }
        }

        //System.out.println("####### size: "+result.size());
        return result;
    }

    // menu1 : 상세보기 - 학기별 수강 내역
    public List<HomeworkCourses> getYearSemesterHistory(int year, int semester) {
        return homeworkDao.getYearSemesterCoursesRecords(year, semester);
    }

    // menu2 : 수강 신청 db에 저장.
    public void insert(HomeworkRegist homeworkRegist){
        homeworkDao.insert(homeworkRegist);
    }

    // menu3 : 수강 신청 테이블 전체 레코드 가져오기
    public List<HomeworkRegist> getAllRegistration() {
        return homeworkDao.getAllRegistration();
    }
}
