package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */

    public static final Prefix PREFIX_DESCRIPTION = new Prefix("t/");
    public static final Prefix PREFIX_MEMBER = new Prefix("m/");
    public static final Prefix PREFIX_NOTE = new Prefix("n/");
    public static final Prefix PREFIX_DEADLINE = new Prefix("d/");
    public static final Prefix PREFIX_SORT_ORDER = new Prefix("o/");
    public static final Prefix PREFIX_SORT_TYPE = new Prefix("ty/");
    public static final Prefix PREFIX_PRIORITY = new Prefix("p/");

}
