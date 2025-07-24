package br.dev.carloslima.backend.service;

import br.dev.carloslima.backend.model.UserModel;
import br.dev.carloslima.backend.model.dto.CreateUserDto;
import br.dev.carloslima.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /***
     * Lista todos os usuarios
     * @return Lista de UserModel
     */
    public List<UserModel> listAll(){
        return userRepository.findAll();
    }

    /***
     * Lista todos os usuarios ativo.
     * @return
     */
    public List<UserModel> listAllActive(){
        return userRepository.findByActive((short) 1);
    }

    public UserModel created (CreateUserDto dto){

        try {
            UserModel userEtity = new UserModel(dto.getName(), dto.getSurname(), dto.getEmail(), dto.getPassword());
            return userRepository.save(userEtity);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
