package br.dev.carloslima.backend.service;

import br.dev.carloslima.backend.model.PermissionModel;
import br.dev.carloslima.backend.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository repository;

    /***
     * Lista das as permissoes existente para um usuario
     * @return List<PermissionModel>
     */
    public List<PermissionModel> findAll(){
        return repository.findAll();
    }

    public int createdPermission(PermissionModel permissionModel){
       try{
           repository.save(permissionModel);
       } catch (RuntimeException e) {
           return 0;
       }
       return 1;
    }
}
