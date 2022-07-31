package hello.servlet.domain.member;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
    *동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
    */
//싱글톤 패턴: 객체를 하나만 생성해서 공유해야 하므로 생성자를 private로 막음
//자바 빈을 사용하지 않고, 순수 서블릿으로 구현
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //static사용: 객체를 여러 개 생성해도 변수는 한개 생성
    private static long sequesnce = 0L; //static사용

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequesnce);
        store.put(member.getId(), member);
        return member;
    }
    public Member findById(Long id){
        return store.get(id);
    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }


}
