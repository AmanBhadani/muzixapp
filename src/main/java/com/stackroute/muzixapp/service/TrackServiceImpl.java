package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){

        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) {
        Track track = trackRepository.findById(id).get();
        return track;
    }

    @Override
    public void deleteTrack(int id)
    {
        trackRepository.delete(getTrackById(id));
    }

    @Override
    public List<Track> getAllTracks()
    {
        return trackRepository.findAll();
    }
    public void deleteall(){
        trackRepository.deleteAll();
    }

    @Override
    public Track updateTrack(int id, String comment) {
        Track track1 = trackRepository.findById(id).get();
        track1.setComment(comment);
        Track savedTrack = trackRepository.save(track1);
        return savedTrack;
    }
}
