package org.motechproject.scheduletracking.api.domain;

import org.junit.Before;
import org.junit.Test;
import org.motechproject.scheduletracking.api.BaseScheduleTrackingTest;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class MilestoneTest extends BaseScheduleTrackingTest {
    private Milestone milestone;

    @Before
    public void setUp() {
        milestone = new Milestone("M1", null, wallTimeOf(1), wallTimeOf(2), wallTimeOf(3), null);
    }

    @Test
    public void window() {
        assertNotNull(milestone.window(WindowName.Upcoming));
    }

    @Test
    public void fallsIn() {
//        assertEquals(WindowName.Upcoming, milestone.applicableWindow(daysAgo(2)));
        assertEquals(WindowName.Upcoming, milestone.applicableWindow(daysAgo(7)));
        assertEquals(WindowName.Upcoming, milestone.applicableWindow(daysAgo(9)));
        assertEquals(WindowName.Upcoming, milestone.applicableWindow(daysAgo(14)));
        assertEquals(WindowName.Due, milestone.applicableWindow(daysAgo(16)));
        assertEquals(WindowName.Due, milestone.applicableWindow(daysAgo(15)));
        assertEquals(WindowName.Due, milestone.applicableWindow(daysAgo(21)));
        assertEquals(WindowName.Past, milestone.applicableWindow(daysAgo(22)));
    }
}
