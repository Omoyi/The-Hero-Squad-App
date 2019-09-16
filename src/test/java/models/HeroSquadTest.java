package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroSquadTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        HeroSQ hero = new HeroSQ("Day 1: Intro");
        assertEquals(true, hero instanceof HeroSQ);
        assertEquals("Day 1: Intro", hero.getData());
    }
}

