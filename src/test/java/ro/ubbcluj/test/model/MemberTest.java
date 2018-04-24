package ro.ubbcluj.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ro.ubbcluj.model.Member;
import ro.ubbcluj.repository.MemberRepository;

public class MemberTest {

    @Test
    public void constructorWorksProperly() {
        Member member = new Member("1", "name");

        assertEquals(member.getName(), "name", "getName did not return expected \"name\"");
        assertEquals(member.getId(), 1, "getId did not return expected \"name\"");
    }

    @Test
    public void settersWork() {
        Member member = new Member("1", "name");

        member.setName("newName");
        assertEquals(member.getName(), "newName", "name not set");

        member.setId("1");
        assertEquals(member.getId(), 1, "id not set");
    }
}
