package AB1;
import java.util.UUID;
/**
 * Key-Element für Mengenmodelierungen.
 * 
 * Key wird automatisch bei Instanzerzeugung generiert.
 * 
 * @author Helena Lajevardi
 */
public class Key {
  
  private final UUID keyValue;
  
  public Key() {
    this.keyValue = UUID.randomUUID();
  }

  public UUID getValue() {
    return keyValue;
  }
  
}
