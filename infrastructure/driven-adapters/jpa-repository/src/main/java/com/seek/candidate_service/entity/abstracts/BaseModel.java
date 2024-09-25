package com.seek.candidate_service.entity.abstracts;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String uuid;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime deletedAt;

    @Builder.Default
    private boolean isDeleted = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseModel that)) return false;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "BaseModel {" + "uuid = " + uuid + "}";
    }

    @PrePersist()
    public void prePersist() {
        this.uuid = UUID.randomUUID().toString();
    }
}