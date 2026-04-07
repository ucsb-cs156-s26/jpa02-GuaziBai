package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assertTrue(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void addMember_adds_member_to_list() {
        team.addMember("Alice");
        assertTrue(team.getMembers().contains("Alice"));
        assertEquals("Team(name=test-team, members=[Alice])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assertFalse(team.equals("not a team"));
    }

    @Test
    public void equals_returns_true_for_same_name_and_same_members() {
        Team t2 = new Team("test-team");
        assertTrue(team.equals(t2));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team t2 = new Team("other-team");
        assertFalse(team.equals(t2));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        assertFalse(team.equals(t2));
    }

    @Test
    public void hashCode_returns_same_value_for_equal_objects() {
        Team t2 = new Team("test-team");
        assertEquals(team.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_same_value_for_equal_objects_with_members() {
        team.addMember("Alice");

        Team t2 = new Team("test-team");
        t2.addMember("Alice");

        assertEquals(team.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        assertEquals(-1226298695, team.hashCode());
    }
}