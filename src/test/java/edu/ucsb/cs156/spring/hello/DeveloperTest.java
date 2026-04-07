package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Annie Y.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("GuaziBai", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s26-04", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_Annie() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Annie Y."), "Team should contain Annie Y.");
    }

    @Test
    public void getTeam_returns_team_with_Eric() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Erik"),"Team should contain Eric");
    }

    @Test
    public void getTeam_returns_team_with_Ertan() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Ertan"),"Team should contain Ertan");
    }

    @Test
    public void getTeam_returns_team_with_Tanvi() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Tanvi"),"Team should contain Tanvi");
    }

    @Test
    public void getTeam_returns_team_with_Vanessa() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Vanessa"),"Team should contain Vanessa");
    }

    @Test
    public void getTeam_returns_team_with_Vincent() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Vincent"),"Team should contain Vincent");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
