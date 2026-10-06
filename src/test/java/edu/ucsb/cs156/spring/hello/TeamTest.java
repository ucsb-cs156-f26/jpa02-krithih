package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team"); 
        team.addMember("John Doe");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void getMembers_returns_correct_members() {
        assert(team.getMembers().contains("John Doe"));
    }

    @Test
    public void equals_returns_false() {
        assert(!team.equals(5));
    }

    @Test
    public void equals_returns_true() {
        assert(team.equals(team));
    }

    @Test
    public void toString_returns_correct_string() {
        assert(team.toString().equals("Team(name=test-team, members=[John Doe])"));
    }

    @Test
    public void equals_returns_true_for_different_object_same_name_and_members() {
        Team other = new Team("test-team");
        other.addMember("John Doe");
        assertEquals(team, other);
    }

    @Test
    public void equals_returns_false_when_names_differ() {
        Team other = new Team("other-team");
        other.addMember("John Doe");
        assertNotEquals(team, other);
    }

    @Test
    public void equals_returns_false_when_members_differ() {
        Team other = new Team("test-team");
        other.addMember("Jane Doe");
        assertNotEquals(team, other);
    }

    @Test
    public void hashCode_returns_same_value_for_equal_objects() {
        int result = team.hashCode();
        int expectedResult = -1092059396;
        assertEquals(expectedResult, result);
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
