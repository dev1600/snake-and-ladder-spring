package com.snakeandladder.snakeandladder.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.snakeandladder.snakeandladder.model.Snakes;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class SnakesDeserializer extends JsonDeserializer<Snakes> {
    @Override
    public Snakes deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException{
//        System.out.println("Got into Serialization method");
        ObjectMapper mapper=(ObjectMapper) jp.getCodec();
        JsonNode node =mapper.readTree(jp);

        Map<Integer,Integer> snakesMap=new HashMap<>();
        JsonNode snakesNode=node.get("snakeCoordinates");

        if(snakesNode!=null){
            Iterator<Map.Entry<String,JsonNode>> iterator=snakesNode.fields();

            while(iterator.hasNext()){
                Map.Entry<String,JsonNode> entry=iterator.next();
                Integer key=Integer.parseInt(entry.getKey());
                Integer value=entry.getValue().asInt();
                snakesMap.put(key,value);
            }
        }

        Snakes snakes=new Snakes();
        snakes.setSnakeCoordinates(snakesMap);
        return snakes;
    }
}
