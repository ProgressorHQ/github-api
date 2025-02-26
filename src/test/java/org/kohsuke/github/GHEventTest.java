package org.kohsuke.github;

import org.junit.Test;
import org.kohsuke.github.GHEvent.GitHubEventType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GHEventTest {

    /**
     * Function from GHEventInfo to transform string event to GHEvent which has been replaced by static mapping due to
     * complex parsing logic below
     */
    private static GHEvent oldTransformationFunction(String t) {
        if (t.endsWith("Event")) {
            t = t.substring(0, t.length() - 5);
        }
        for (GHEvent e : GHEvent.values()) {
            if (e.name().replace("_", "").equalsIgnoreCase(t)) {
                return e;
            }
        }
        return GHEvent.UNKNOWN;
    }

    @Test
    public void regressionTest() {
        assertThat(GitHubEventType.transformToGHEvent("NewlyAddedOrBogusEvent"), is(GHEvent.UNKNOWN));
        for (GitHubEventType gitHubEventType : GitHubEventType.values()) {
            assertThat(GitHubEventType.transformToGHEvent(gitHubEventType.name()),
                    is(oldTransformationFunction(gitHubEventType.name())));
        }
    }
}
