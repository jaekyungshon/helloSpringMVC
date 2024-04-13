package kr.ac.hansung.cse.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// ch05 : spring security Filter test

@WebFilter("/*") // 이 필터는 모든 request를 가로채겠다!
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // 핵심 : 처리하고자 하는 내용 함수
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // ServletRequest를 상속해서 확장한 것이 HttpServletRequest
        System.out.println(((HttpServletRequest) request).getRequestURL()); // filter 가져오기
        // 출력 URL : localhost:8080/접속url이 나옴.

        // pass the request along filter chain
        // Filter들을 연결하는 작업
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
