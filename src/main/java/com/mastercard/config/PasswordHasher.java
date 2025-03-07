import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode("d1k4@passw0rd"); // Ganti dengan password yang ingin di-hash
        System.out.println("Hashed Password: " + hashedPassword);
    }
}