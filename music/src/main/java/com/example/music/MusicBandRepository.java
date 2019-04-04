package com.example.music;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicBandRepository extends JpaRepository<MusicBand, Long> {
}
