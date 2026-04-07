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
    public void getTeam_returns_team_with_ANNIE() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("ANNIE."), "Team should contain ANNIE.");
    }

    @Test
    public void getTeam_returns_team_with_ERIK() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("ERIK"),"Team should contain ERIK");
    }

    @Test
    public void getTeam_returns_team_with_ERTAN() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("MEHMET ERTAN"),"Team should contain MEHMET ERTAN");
    }

    @Test
    public void getTeam_returns_team_with_TANV() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("TANVI"),"Team should contain TANV");
    }

    @Test
    public void getTeam_returns_team_with_Vanessa() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Vanessa"),"Team should contain Vanessa");
    }

    @Test
    public void getTeam_returns_team_with_VINCENT() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("VINCENT BATHANH"),"Team should contain VINCENT BATHANH");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
