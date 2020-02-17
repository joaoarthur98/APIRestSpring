package br.com.erudio.converter;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

public class DozerConverter {
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObject(O origem, Class<D> destino){
		return mapper.map(origem, destino);
	}
	
	public static <O, D> List<D> parseListObjects(List<O> origem, Class<D> destino){
		List<D> destinoObjects = new ArrayList<D>();
		
		for (Object o: origem) {
			destinoObjects.add(mapper.map(o, destino)); 	
		}
		return destinoObjects;
	}
}
