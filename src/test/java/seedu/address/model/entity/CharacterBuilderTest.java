package seedu.address.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.address.model.entity.Character.CharacterBuilder;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.tag.Tag;
import seedu.address.testutil.InventoryStub;

/**
 * Test class for Character.CharacterBuilder
 */
public class CharacterBuilderTest {
    private static final Name DEFAULT_NAME = new Name("TEST");
    private static final Stats DEFAULT_STATS = new Stats();
    private static final Inventory DEFAULT_INVENTORY = new Inventory();
    private static final Progression DEFAULT_PROGRESSION = new Progression();
    private static final Set<Tag> DEFAULT_TAGS = new HashSet<>();

    /**
     * Test if the optional setters of the builder produce the default values
     */
    @Test
    public void build_useDefaultFields_allDefaultFieldsPresent() {
        CharacterBuilder baseBuilder = new CharacterBuilder(DEFAULT_NAME);
        Character baseChar = baseBuilder.build();
        assertNotNull(baseChar);
        assertEquals(DEFAULT_STATS, baseChar.getStats());
        assertEquals(DEFAULT_INVENTORY, baseChar.getInventory());
        assertEquals(DEFAULT_PROGRESSION, baseChar.getProgression());
        assertEquals(DEFAULT_TAGS, baseChar.getTags());
    }

    /**
     * Test if the optional setters of the builder sets the fields to the given values
     */
    @Test
    public void build_setAllFields_allFieldsSetCorrectly() {
        final Stats customStats = new Stats(1, 1, 1);
        final Inventory customInventory = new InventoryStub();
        final Progression customProgression = new Progression(99, 1);
        final Set<Tag> customTags = new HashSet<>();
        customTags.add(new Tag("Testing"));

        CharacterBuilder customBuilder = new CharacterBuilder(DEFAULT_NAME)
                .setStats(customStats)
                .setInventory(customInventory)
                .setProgression(customProgression)
                .setTags(customTags);

        Character customChar = customBuilder.build();
        assertNotNull(customChar);
        assertEquals(customStats, customChar.getStats());
        assertEquals(customInventory, customChar.getInventory());
        assertEquals(customProgression, customChar.getProgression());
        assertEquals(customTags, customChar.getTags());
    }
}
