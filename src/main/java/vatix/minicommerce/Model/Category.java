package vatix.minicommerce.Model;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vatix.minicommerce.Payload.CategoryTranslationDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long id;
	
	@Column(name = "status")
	public boolean status;
	
	@CreatedDate
	private Long created_at;
	
	@LastModifiedDate
	private Long updated_at;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CategoryTranslation> translations;
   
    public Category(boolean status, List<CategoryTranslation> translations) {
		this.status = status;
		this.translations = translations;
	}

	public Category(boolean status) {
		this.status = status;
	}
    
}
