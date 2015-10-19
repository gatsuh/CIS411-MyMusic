package com.wesleyreisz.mymusic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class SonglistActivityFragment extends Fragment {

    public SonglistActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songlist, container, false);
        ListView listView = (ListView)view.findViewById(R.id.list_view);

        // call the service and get a list of song names
        MockMusicService service = new MockMusicService();
        List<Song> songs = service.findAll();
        List<String> songNames = new ArrayList<String>();

        //loop over list of songs and create list of song names as strings
        for(Song song:songs){
            if (song.getAlbumTitle().length() > 0) {
                songNames.add(song.getAlbumTitle());
            }
            };
        //create adapter with list of song names which are now strings
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, songNames);

        // set adapter to list view
        listView.setAdapter(adapter);

        return view;
    }
}
