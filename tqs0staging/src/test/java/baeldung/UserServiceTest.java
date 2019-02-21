/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baeldung;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
 
/**
 *
 * @author ico
 */
public class UserServiceTest {

    @Mock
    List<String> mmockedList;


    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");

        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }



    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mmockedList.add("one");
        Mockito.verify(mmockedList).add("one");
        assertEquals(0, mmockedList.size());

        Mockito.when(mmockedList.size()).thenReturn(100);
        assertEquals(100, mmockedList.size());
    }



//    @Mock UserRepository userRepository;
//
//    public UserServiceTest() {
//    }
//
//    @BeforeEach
//    public void setUp(@Mock SettingRepository settingRepository) {
//    userService = new DefaultUserService(userRepository, settingRepository, mailClient);
//    Mockito.lenient().when(settingRepository.getUserMinAge()).thenReturn(10);
//    when(settingRepository.getUserNameMinLength()).thenReturn(4);
//    Mockito.lenient().when(userRepository.isUsernameAlreadyExists(any(String.class))).thenReturn(false);
//    }
//
//
//@Test
//void givenValidUser_whenSaveUser_thenSucceed(@Mock MailClient mailClient) {
//    // Given
//    user = new User("Jerry", 12);
//    when(userRepository.insert(any(User.class))).then(new Answer<User>() {
//        int sequence = 1;
//             
//        @Override
//        public User answer(InvocationOnMock invocation) throws Throwable {
//            User user = (User) invocation.getArgument(0);
//            user.setId(sequence++);
//            return user;
//        }
//    });
// 
//    userService = new DefaultUserService(userRepository, settingRepository, mailClient);
// 
//    // When
//    User insertedUser = userService.register(user);
//         
//    // Then
//    verify(userRepository).insert(user);
//    Assertions.assertNotNull(user.getId());
//    verify(mailClient).sendUserRegistrationMail(insertedUser);
//}




    @AfterEach
    public void tearDown() {
    }

}