package hello.aop.exam;

import hello.aop.exam.annotation.Retry;
import hello.aop.exam.annotation.Trace;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {

    private static int seq = 0;

    /**
     * 5번 중에 1번은 실패하는 요청
     */
    @Trace
    @Retry(4)
    public String save(String itemId) {
        seq++;

        if (seq % 5 == 0) {
            throw new IllegalStateException("예외 발생");
        }

        return "ok";
    }
}
