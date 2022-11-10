package com.cancer.formatter;

import javax.swing.text.MaskFormatter;

public class Mascaras {
	
	 private  MaskFormatter telefone, cep, cpf, data;
	    
	    private static final  Mascaras mascaras = new Mascaras();
	    
	    public enum MascaraTipo{
	        CEP, TELEFONE, CPF, DATA;
	    }
	    
	    private Mascaras(){
	        
	        try{
	            telefone = new MaskFormatter("(##) ####-####");
	            telefone.setPlaceholderCharacter('_');
	            
	            cep = new MaskFormatter("#####-###");
	            cep.setPlaceholderCharacter('_');
	            
	            cpf = new MaskFormatter("###.###.###-##");
	            cpf.setPlaceholderCharacter('_');
	            
	            data = new MaskFormatter("dd/MM/yyyy");
	            data.setPlaceholderCharacter('_');
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }    
	    }
	    
	    public static Mascaras getInstance (){
	        return mascaras;
	    }
	    
	    public MaskFormatter getMascara(MascaraTipo mask){
	        
	        switch(mask){
	            case CEP:
	                return cep;
	            case CPF:
	                return cpf;
	            case TELEFONE:
	                return telefone;
	            case DATA:
	            	return data;
	            default:
	                return null;
	        }
	    }
	    
	}


