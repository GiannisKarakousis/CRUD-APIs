package com.example.crud_apis.service;

import com.example.crud_apis.dto.UserCreateDto;
import com.example.crud_apis.dto.UserDto;
import com.example.crud_apis.dto.UserShortDto;
import com.example.crud_apis.exception.UserNotFoundException;
import com.example.crud_apis.persistence.entity.User;
import com.example.crud_apis.persistence.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public Collection<UserDto> findAll() {
        Collection<User> userCollection = this.userRepository.findAll();

        Type type = new TypeToken<Collection<UserDto>>() {
        }.getType();

        return modelMapper.map(userCollection, type);
    }

    public UserDto findById(Long id) throws UserNotFoundException {
        Optional<User> optionalUserEntity = this.userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            return modelMapper.map(optionalUserEntity.get(), UserDto.class);
        } else {
            throw new UserNotFoundException();
        }
    }

    public UserDto findByAfm(String afm) throws UserNotFoundException {
        Optional<User> optionalUserEntity = this.userRepository.findByAfm(afm);

        if (optionalUserEntity.isPresent()) {
            return modelMapper.map(optionalUserEntity.get(), UserDto.class);
        } else {
            throw new UserNotFoundException();
        }
    }

    public UserShortDto findByIdNameOnly(Long id) throws UserNotFoundException {
        Optional<User> optionalBeneficiaryEntity = this.userRepository.findById(id);

        if (optionalBeneficiaryEntity.isPresent()) {
            return modelMapper.map(optionalBeneficiaryEntity.get(), UserShortDto.class);
        } else {
            throw new UserNotFoundException();
        }
    }

    public UserCreateDto create(UserCreateDto userCreateDto) {
        UserDto userDto = modelMapper.map(userCreateDto, UserDto.class);
        Boolean checkRequiredOneFieldIsNotNull = userDto.equals(new UserDto());

        if (checkRequiredOneFieldIsNotNull) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

        User user = modelMapper.map(userCreateDto, User.class);
        User createdEntity = this.userRepository.save(user);

        return modelMapper.map(createdEntity, UserCreateDto.class);
    }

    public UserDto update(UserDto userDto) {
        Optional<User> optionalUserEntity = this.userRepository.findById(userDto.getId());

        if (optionalUserEntity.isPresent()) {
            modelMapper.map(userDto, optionalUserEntity.get());
            this.userRepository.save(optionalUserEntity.get());
        } else {
            throw new UserNotFoundException();
        }
        return userDto;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}











