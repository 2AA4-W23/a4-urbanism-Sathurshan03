package ca.mcmaster.cas.se2aa4.a3.island.BodiesOfWater;

import java.util.ArrayList;
import java.util.List;
import ca.mcmaster.cas.se2aa4.a3.island.BuildingBlocks.TileVertex;
import ca.mcmaster.cas.se2aa4.a3.island.BuildingBlocks.TileSegment;

public class River {
    List<TileVertex> riverVertices;
    List<TileSegment> riverSegments;

    public River(TileVertex riverStart){
        riverVertices = new ArrayList<>();
        riverSegments = new ArrayList<>();
        riverVertices.add(riverStart);
    }

    public void addRiverVertex(TileVertex riverVertex){
        riverVertices.add(riverVertex);
    }
    
    public void addRiverSegment(TileSegment riverSegment){
        riverSegments.add(riverSegment);
    }

    public Boolean canAddVertexToRiver(TileVertex vertex){
        //ensures no duplicates in the river
        if (riverVertices.contains(vertex)){
            return false;
        }
        return true;
    }

    public void setRiverAttributes(){
        //set the attributes for the river segments
        for (TileSegment segment: riverSegments){
            segment.setRiver();
            segment.setSegmentVertexRiver();
        }
    }
}
