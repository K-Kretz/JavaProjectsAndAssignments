package com.secure.util;

public class CaesarCiperTwoKeysDecrypt {
	
	public String encrypt(String message, int key) {
		
		StringBuilder sb = new StringBuilder(message.toUpperCase());
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String newAlphabet = alphabet.substring(key) +alphabet.substring(0,key);
		
		for(int i=0; i<sb.length(); i++)
		{
			char letter = sb.charAt(i);
			
			int index = alphabet.indexOf(letter);
			
			if(index != -1)
				sb.setCharAt(i, newAlphabet.charAt(index));
		}
		
		return sb.toString();
	}
	
	public int[] countLetters(String encrypt) {
		
		int[] counter = new int[26];
		String alphabet ="abcdefghijklmnopqrstuvwxyz";
		
		for(int i=0; i<encrypt.length(); i++) {
			
			char letter = Character.toLowerCase(encrypt.charAt(i));
			
			int index = alphabet.indexOf(letter);
			
			if(index != -1)
				counter[index]++;
		}
		
		return counter;
	}
	public static String encryptTwoKeys(String input, int key1, int key2)
	{
	    
        StringBuilder sb = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String newAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String newAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        
        for(int i=0; i<sb.length(); i++)
        {
            if(Character.isUpperCase(sb.charAt(i)))
            {
                char letter = sb.charAt(i);
                
                int index = alphabet.indexOf(letter);
                
                if(index != -1)
                {
                    if(i%2 != 0)
                        sb.setCharAt(i,newAlphabet2.charAt(index));
                    if(i%2 == 0)
                        sb.setCharAt(i,newAlphabet1.charAt(index));
                }   
            }
            if(Character.isLowerCase(sb.charAt(i)))
            {
                char letter = Character.toUpperCase(sb.charAt(i));
                
                int index = alphabet.indexOf(letter);
                
                if(index != -1)
                {
                    if(i%2 != 0)
                        sb.setCharAt(i,Character.toLowerCase(newAlphabet2.charAt(index)));
                    if(i%2 == 0)
                        sb.setCharAt(i,Character.toLowerCase(newAlphabet1.charAt(index)));
                }   
            }
        }
        
        return sb.toString();
    }
	
	public String decrypt(String encrypt) {
		
		int[] freq = countLetters(encrypt);
		
		int mostCommonLetterIndex = maxIndex(freq); 
		
		int decryptKey = mostCommonLetterIndex - 4;
		
		if(mostCommonLetterIndex < 4)
		{
			decryptKey = 26 - (4-mostCommonLetterIndex);
		}
		
		return encrypt(encrypt,26-decryptKey);
	}

	public int maxIndex(int[] freq) {
	
		int maxIndex = 0;
		for(int i=0; i<freq.length; i++)
		{
			if(freq[i] > freq[maxIndex])
				maxIndex =i;
		}
		
		return maxIndex;
	}
	public String halfOfString(String message, int start) {
		
		StringBuilder sbNew = new StringBuilder();
		for(int i=start; i<message.length(); i+=2) 
		{
			sbNew.append(message.charAt(i));
				
		}
		
		return sbNew.toString();
	}

	public int getKey(String s) {
		
		int[] freq = countLetters(s);
		
		int mostCommonLetterIndex = maxIndex(freq); 
		
		int decryptKey = mostCommonLetterIndex - 4;
		
		if(mostCommonLetterIndex < 4)
		{
			decryptKey = 26 - (4-mostCommonLetterIndex);
		}
		
		
		return decryptKey;
	}
	
	public String decryptTwoKeys(String encrypted) {
		
		String firstHalf = halfOfString(encrypted, 0);
		String secondHalf = halfOfString(encrypted, 1);
		
		int firstHalfKey = getKey(firstHalf);
		int secondHalfKey = getKey(secondHalf);
		
		System.out.println("First Key: " + firstHalfKey);
		System.out.println("Second Key: " + secondHalfKey);
		
		
		
		return encryptTwoKeys(encrypted, 26-firstHalfKey,26-secondHalfKey);
	}
	public String decryptTwoKeys(String encrypted, int key1, int key2) {
		
		String firstHalf = halfOfString(encrypted, 0);
		String secondHalf = halfOfString(encrypted, 1);
		
		int firstHalfKey = key1;
		int secondHalfKey = key2;
		
		System.out.println("First Key: " + firstHalfKey);
		System.out.println("Second Key: " + secondHalfKey);
		
		
		
		return encryptTwoKeys(encrypted, 26-firstHalfKey,26-secondHalfKey);
	}
	

	public static void main(String[] args) {
		CaesarCiperTwoKeysDecrypt ccTKD = new CaesarCiperTwoKeysDecrypt();
		
		//String EncryptedMessage = ccTKD.encryptTwoKeys("Just a test string with lots of eeeeeeeeeeeeeeeees", 23, 2);
		//System.out.println(EncryptedMessage);
		//String decryptedMessage = ccTKD.decrypt(EncryptedMessage);
		//System.out.println(decryptedMessage);
		
		//String halfString = ccTKD.halfOfString("Qbkm Zgis", 0);
		//System.out.println(halfString);
		//String halfString1 = ccTKD.halfOfString("Qbkm Zgis", 1);
		//System.out.println(halfString1);
		
		//int key = ccTKD.getKey("Just a test string with lots of eeeeeeeeeeeeeeeees");
		//System.out.println(key);
		
		System.out.println(ccTKD.decryptTwoKeys("Xifqvximt tsdtlxzrx iijirvtl ek Uybi afvbw yehvv xyi gfqdse iekmfrrpzdrxzse fj xyi jzich sw tsdtlxrxzseec xifqvxic, fjkie xmmie zr xyi trwk, xyek klv nsipu rvfyeh yj zw xyvvi-hzqvrjmfrrp eeh ulijxzsew lfa xymekj zr xymj nsipu iiceki xf vetl sklvv eii melvvvrkpp xifqvximt. Xrov dsmmek e tzees xyvfyxl e hfsi-wvrqv rru gprremek e jcmxlk-gekl xyek rzfmuw gfpcmjmfrj nmkl sklvv ezvgprrvw ej kaf vbrqgpvw. Zx wyslpu klvvvjfvv esk jyitimji xyek tsdtlxzrx gvftvvkmvw esslx xyiji kvsdikvzg xymekj rru klvmi zrkiietxzse rvv tsdqfr-tceti eeh mdtfvkeex. Nlzpv klzw mj jxzpc r mecmu rvxydiex, ni afych pzov ks edieh xyek dsjx sw klv xifqvximt hyvwkmfrj giftci gfrtiir xyidwvpmij nmkl lrzv ks hf nmkl lfa xymekj rvv tservgkiu. Mk zw mdtfvkeex xyek ymxlnepw eii wljwmtmvrkpp jxiezkyx eeh wdsfxy ks wltgsix xyi himmmek sw wejx grvj, flx eesklvv ijwvrkmrp tisgiixp, aymtl av lwlecpp kebi jfv kieexvh, zw xyek ymxlnepw eii gfrkmeyfyj, mehviu tservgkmek E xf S, eeh rfx nlwk rtgvfbzqrxvpp. Xyi gfviijtfrumek wlfwmvpu fj gfqgykekmfrrp kvsdikvp zw swxvr vvjvviiu ks ej tsdtlxrxzseec ksgscsxc. R xsfh tfvkmfr sw fyi vjwsixj dep si gcejwzjziu ks fvpfrx ks xymj jysjzich eeh eii himmie sc egtcmtekmfrj zr e zrvzikc sw fxyii wmvpuw, klv gvvhzgkmfr sw klv jxiytxlvv fj jfpuiu gvfxvmew eeh xyi vvgfrjxiytxzse fj llqrr sikrrj sizrx kaf. Xyi lrpcqrvb fj slv afvb zw jrwk rpxsimkldw xyek zqgpvqvrk deklvqrxzgrp qfhvpj ks swjvv mewzkyxj zrks eeh eewniiw xf jytl ulijxzsew.\r\n"
				+ "\r\n"
				+ "Av rvv vbgpfvzrx zwjyvw wlgy rw lfa xvgyrzulij wsi jsczzrx gvffcidw grr fv umjgfzvvvh, zqgvfzvh, rrrppdvh, rru uidsewkvrxvh xf si gfviitx si ftkmdec. Av vbgitx xf debi pveumek gfrkvzflxzsew me tsdtlxrxzseec xifqvxic, xifqvximt dsuicmek, ueke wkvlgkyiij, lzky-giijfvdeegv tsdtlxzrx, M/S-iwjzgziegp wsi vbkiirrp qvqfvp, kvsxvrtymt zrwsiqrxzse jcjxvqj (KZW), fzscsxmtec tsdtlxzrx, eeh hrxr tsdtiijwzse.\r\n"
				+ "\r\n"
				+ "Sitelwv fj xyi kvsdikvzg rrxlvv fj xyi tycjmtec nsipu zr aymtl av cmmi, xifqvximt gvffcidw eimji me rrp rvve xyek zrkiietxj nmkl xyi tycjmtec nsipu. Kvsdikvzg gfqgykmek jfglwvw se uijmxrzrx, eeeccqmek, rru zqgpvqvrkmek iwjzgziex eckfvzxyqj wsi xifqvximt gvffcidw. Klv xifqvximt tsdtlxzrx xvfyg fj xyi hvtrvkqvrk zw mexvveekmfrrpcc vvrfaeiu wsi zxj tseximsykmfrj ks xyi jlruediexrp tisspvqj zr gfqgykekmfrrp kvsdikvp, euhiijwzrx dejwzzv ueke qrrrkvqvrk zwjyvw me xifqvximt gvffcidw, rru rtgppmek kvsdikvzg xvgyrzulij ks e zrvzikc sw rvvej, megcyumek qfpvglprv fzscsxc, xifqvximt dsuicmek, issskmtw, xifkieglzg mejfvdekmfr wpwkidw, vgfpfkp, eeh tysksemtw.\r\n"
				+ "\r\n"
				+ "Xyi kislt etxzzvpp tscprffvrxvw azxy fxyii xvfygw azxyme klv uigeixdiex eeh azxy klv iijirvtlvvj zr sklvv hvtrvkqvrkw ek Uybi. Klvc gfpcessieki azxy wetycxp zr Qrxyidekmtw, Smfpfkp, Fzstlvqzwkvp, Icitximtec rru Tsdtlxvv Iekzrviimek, rru klv Emtlfprw Wtlfsc fj Iezzvfrdiex. Sipseh Hlov, xyi kislt ecwf tscprffvrxvw azxy iijirvtlvvj rx zrvzslw xft mewkmkykij. Fvgryji sw zxj uigxy rru svveuxy, xyi kvsdikvzg gfqgykmek kislt ek Uybi mj rvxyrfcc xyi xft kvsdikvzg gfqgykmek kislt me klv eekmfr."));
	}

}
