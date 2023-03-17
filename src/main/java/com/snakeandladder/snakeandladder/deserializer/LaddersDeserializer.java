package com.snakeandladder.snakeandladder.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snakeandladder.snakeandladder.model.Ladders;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LaddersDeserializer extends JsonDeserializer<Ladders> {
    @Override
    public Ladders deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException{
        ObjectMapper mapper=(ObjectMapper) jp.getCodec();
        JsonNode node=mapper.readTree(jp);

        Map<Integer,Integer> laddersMap=new HashMap<>();
        JsonNode laddersNode=node.get("ladderCoordinates");
        System.out.println("Ladders =>"+laddersNode);

        if(laddersNode!=null){
            Iterator<Map.Entry<String,JsonNode>> iterator=laddersNode.fields();
            while(iterator.hasNext()){
                Map.Entry<String,JsonNode> entry=iterator.next();
                Integer key=Integer.parseInt(entry.getKey());
                Integer value=entry.getValue().asInt();
                laddersMap.put(key,value);
            }
        }
        Ladders ladders=new Ladders();
        ladders.setLadderCoordinates(laddersMap);
        return ladders;
    }
}
