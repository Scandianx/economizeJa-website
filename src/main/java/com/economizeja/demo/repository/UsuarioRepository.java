package website.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import lombok.NonNull;
import website.demo.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @NonNull
    public UserDetails findByUsername(String username);
    @NonNull
    public UserDetails findById(long id);
    
    
    
    
}
