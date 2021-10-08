package com.examplestudy.depotapp.security;

import com.examplestudy.depotapp.response.AlreadyExistException;
import com.examplestudy.depotapp.user.User;
import com.examplestudy.depotapp.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {
    @Mock
    private UserRepository mockedRepository;
   // @Test
    ///public void shouldCall(){
        //when(mockedRepository.findByLogin("mod")).thenReturn(null);
        //UserDetailServiceImpl service = new UserDetailServiceImpl(mockedRepository);
        //User user = new User("mod","123",Role.MODERATOR);
        //service.addModerator(user);
        //verify(mockedRepository,times(1)).save(user);
    //}
    @Test
    public void shouldThrowAlreadyExistException(){
        when(mockedRepository.findByLogin("admin")).thenReturn(new User());
        UserDetailsServiceImpl service = new UserDetailsServiceImpl(mockedRepository);
        Throwable thrown = Assertions.assertThrows(AlreadyExistException.class,
                ()->service.addUser(new AuthenticationRequest("admin",anyString())));
        Assertions.assertEquals("this login is busy",thrown.getMessage());


    }
    @Test
    public void shouldNotThrowException(){
        when(mockedRepository.findByLogin("otherLogin")).thenReturn(null);
        UserDetailsServiceImpl service = new UserDetailsServiceImpl(mockedRepository);
        Assertions.assertDoesNotThrow(
                ()->service.addModerator(new AuthenticationRequest("otherLogin","1234")));

    }

}