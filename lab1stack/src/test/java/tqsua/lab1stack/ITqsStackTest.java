package tqsua.lab1stack;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author ico
 */
public class ITqsStackTest {
    
    
    ITqsStack<String> instance;
    
    @BeforeEach
    public void init() {
        instance = new TqsSimpleStack<>();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    
    @Test
    @DisplayName("A stack is empty on construction")       
    public void testIsEmpty() {
        assertTrue( instance.isEmpty() );
    }
    
    @Test
    @DisplayName("A stack has size 0 on construction")
    public void testIsZeroSizeOnEmpty() {
        assertEquals( 0, instance.size() );
    }
    
    
    @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows( NoSuchElementException.class, instance::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(NoSuchElementException.class, instance::peek);
        }
        
    
    
    @Test
    public void testPushOnEmptyStack() {
        String item = "One";
        
        instance.push(item);
        assertEquals( 1, instance.size() );
        assertFalse( instance.isEmpty());
        
        instance.push(item);
        assertEquals( 2, instance.size() );        
    }
   
    
}
