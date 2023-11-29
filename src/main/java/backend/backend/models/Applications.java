package backend.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Applications")
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_generator")
    @SequenceGenerator(name = "application_generator", sequenceName = "application_seq")
    @Column(name = "application_id")
    private long applicationId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "notes", nullable = true)
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id")
    private School school;
}
