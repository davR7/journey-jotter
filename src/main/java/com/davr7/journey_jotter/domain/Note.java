package com.davr7.journey_jotter.domain;

import com.davr7.journey_jotter.dtos.CreateNoteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name="trip_id", nullable = false)
    private Trip trip;

    public Note(CreateNoteDto data, Trip trip){
        this.title = data.title();
        this.description = data.description();
        this.url = data.url();
        this.trip = trip;
    }
}
