package nbbrd.heylogs;

import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.ast.LinkNodeBase;
import com.vladsch.flexmark.util.ast.Node;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static nbbrd.heylogs.ExtendedRules.*;
import static nbbrd.heylogs.Nodes.of;
import static nbbrd.heylogs.Sample.using;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;

public class ExtendedRulesTest {

    @Test
    public void test() {
        Node sample = Sample.using("Main.md");
        for (ExtendedRules rule : ExtendedRules.values()) {
            assertThat(Nodes.of(Node.class).descendants(sample).map(rule::validate).filter(Objects::nonNull))
                    .isEmpty();
        }
    }

    @Test
    public void testValidateLimitHeadingDepth() {
        assertThat(of(Heading.class).descendants(using("Main.md")))
                .map(ExtendedRules::validateLimitHeadingDepth)
                .isNotEmpty()
                .filteredOn(Objects::nonNull)
                .isEmpty();

        assertThat(of(Heading.class).descendants(using("InvalidHeadingLevel.md")))
                .map(ExtendedRules::validateLimitHeadingDepth)
                .isNotEmpty()
                .filteredOn(Objects::nonNull)
                .contains(Failure.of(LIMIT_HEADING_DEPTH, "Not expecting level 4", 1, 0))
                .hasSize(1);
    }

    @Test
    public void testValidateHttps() {
        assertThat(of(LinkNodeBase.class).descendants(using("Main.md")))
                .map(ExtendedRules::validateHttps)
                .isNotEmpty()
                .filteredOn(Objects::nonNull)
                .isEmpty();

        assertThat(of(LinkNodeBase.class).descendants(using("NonHttps.md")))
                .map(ExtendedRules::validateHttps)
                .isNotEmpty()
                .filteredOn(Objects::nonNull)
                .contains(Failure.of(HTTPS, "Expecting HTTPS protocol", 1, 0))
                .hasSize(1); // FIXME: should be 2
    }

    @Test
    public void testValidateGitHubIssueRef() {
        assertThat(of(Link.class).descendants(using("Main.md")))
                .map(ExtendedRules::validateGitHubIssueRef)
                .isNotEmpty()
                .filteredOn(Objects::nonNull)
                .isEmpty();

        assertThat(of(Link.class).descendants(using("InvalidGitHubIssueRef.md")))
                .map(ExtendedRules::validateGitHubIssueRef)
                .isNotEmpty()
                .filteredOn(Objects::nonNull)
                .contains(Failure.of(GITHUB_ISSUE_REF, "Expecting GitHub issue ref 172, found 173", 2, 53), atIndex(0))
                .hasSize(1);
    }
}
