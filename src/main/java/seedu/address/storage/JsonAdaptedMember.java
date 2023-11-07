package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.model.tag.Member;
import seedu.address.storage.exceptions.json.IllegalJsonTagValueException;
import seedu.address.storage.exceptions.json.IllegalJsonValueException;


/**
 * Jackson-friendly version of {@link Member}.
 */
class JsonAdaptedMember {

    private final String memberName;

    /**
     * Constructs a {@code JsonAdaptedMember} with the given {@code memberName}.
     */
    @JsonCreator
    public JsonAdaptedMember(String memberName) {
        this.memberName = memberName;
    }

    /**
     * Converts a given {@code Member} into this class for Jackson use.
     */
    public JsonAdaptedMember(Member source) {
        memberName = source.memberName;
    }

    @JsonValue
    public String getMemberName() {
        return memberName;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalJsonValueException if there were any data constraints violated in the adapted tag.
     */
    public Member toModelType() throws IllegalJsonValueException {
        if (!Member.isValidName(memberName)) {
            throw new IllegalJsonTagValueException(Member.MESSAGE_CONSTRAINTS);
        }
        return new Member(memberName);
    }

}
