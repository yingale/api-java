package com.netcore.productmatrix.Services;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CompressionService {

    private static char[] keyStrBase64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
	private static Map<char[], Map<Character, Integer>> baseReverseDic = new HashMap<char[], Map<Character, Integer>>();

    public static String decompressFromBase64(final String inputStr) {
		if (inputStr == null)
			return "";
		if (inputStr.equals(""))
			return null;
		return CompressionService._decompress(inputStr.length(), 32, new DecompressFunctionWrapper() {
			@Override
			public char doFunc(int index) {
				return getBaseValue(keyStrBase64, inputStr.charAt(index));
			}
		});
    }
    private static char getBaseValue(char[] alphabet, Character character) {
		Map<Character, Integer> map = baseReverseDic.get(alphabet);
		if (map == null) {
			map = new HashMap<Character, Integer>();
			baseReverseDic.put(alphabet, map);
			for (int i = 0; i < alphabet.length; i++) {
				map.put(alphabet[i], i);
			}
		}
		return (char) map.get(character).intValue();
	}
    
    private static String _decompress(int length, int resetValue, DecompressFunctionWrapper getNextValue) {
		List<String> dictionary = new ArrayList<String>();
		int next;
		int enlargeIn = 4;
		int dictSize = 4;
		int numBits = 3;
		String entry = "";
		StringBuilder result = new StringBuilder();
		String w;
		int bits, resb; int maxpower, power;
		String c = null;
		DecData data = new DecData();
		data.val = getNextValue.doFunc(0);
		data.position = resetValue;
		data.index = 1;
		
		for (int i = 0; i < 3; i += 1) {
			dictionary.add(i, f(i));
		}
		
		bits = 0;
		maxpower = (int) powerOf2(2);
		power = 1;
		while (power != maxpower) {
			resb = data.val & data.position;
			data.position >>= 1;
			if (data.position == 0) {
				data.position = resetValue;
				data.val = getNextValue.doFunc(data.index++);
			}
			bits |= (resb > 0 ? 1 : 0) * power;
			power <<= 1;
		}
		
	    switch (next = bits) {
	      case 0:
	          bits = 0;
	          maxpower = (int) powerOf2(8);
	          power=1;
	          while (power != maxpower) {
	            resb = data.val & data.position;
	            data.position >>= 1;
	            if (data.position == 0) {
	              data.position = resetValue;
	              data.val = getNextValue.doFunc(data.index++);
	            }
	            bits |= (resb>0 ? 1 : 0) * power;
	            power <<= 1;
	          }
	        c = f(bits);
	        break;
	      case 1:
	          bits = 0;
	          maxpower = powerOf2(16);
	          power=1;
	          while (power!=maxpower) {
	            resb = data.val & data.position;
	            data.position >>= 1;
	            if (data.position == 0) {
	              data.position = resetValue;
	              data.val = getNextValue.doFunc(data.index++);
	            }
	            bits |= (resb>0 ? 1 : 0) * power;
	            power <<= 1;
	          }
	        c = f(bits);
	        break;
	      case 2:
	        return "";
	    }
	    dictionary.add(3, c);
	    w = c;
		result.append(w);
	    while (true) {
	        if (data.index > length) {
	          return "";
	        }

	        bits = 0;
	        maxpower = powerOf2(numBits);
	        power=1;
	        while (power!=maxpower) {
	          resb = data.val & data.position;
	          data.position >>= 1;
	          if (data.position == 0) {
	            data.position = resetValue;
	            data.val = getNextValue.doFunc(data.index++);
	          }
	          bits |= (resb>0 ? 1 : 0) * power;
	          power <<= 1;
	        }
	        // TODO: very strange here, c above is as char/string, here further is a int, rename "c" in the switch as "cc"
	        int cc;
	        switch (cc = bits) {
	          case 0:
	            bits = 0;
	            maxpower = powerOf2(8);
	            power=1;
	            while (power!=maxpower) {
	              resb = data.val & data.position;
	              data.position >>= 1;
	              if (data.position == 0) {
	                data.position = resetValue;
	                data.val = getNextValue.doFunc(data.index++);
	              }
	              bits |= (resb>0 ? 1 : 0) * power;
	              power <<= 1;
	            }

	            dictionary.add(dictSize++, f(bits));
	            cc = dictSize-1;
	            enlargeIn--;
	            break;
	          case 1:
	            bits = 0;
	            maxpower = powerOf2(16);
	            power=1;
	            while (power!=maxpower) {
	              resb = data.val & data.position;
	              data.position >>= 1;
	              if (data.position == 0) {
	                data.position = resetValue;
	                data.val = getNextValue.doFunc(data.index++);
	              }
	              bits |= (resb>0 ? 1 : 0) * power;
	              power <<= 1;
	            }
	            dictionary.add(dictSize++, f(bits));
	            cc = dictSize-1;
	            enlargeIn--;
	            break;
	          case 2:
	        	return result.toString();
			}

	        if (enlargeIn == 0) {
	          enlargeIn = powerOf2(numBits);
	          numBits++;
	        }

	        if (cc < dictionary.size() && dictionary.get(cc) != null) {
	        	entry = dictionary.get(cc);
	        } else {
	          if (cc == dictSize) {
	            entry = w + w.charAt(0);
	          } else {
	            return null;
	          }
	        }
	        result.append(entry);

	        // Add w+entry[0] to the dictionary.
	        dictionary.add(dictSize++, w + entry.charAt(0));
	        enlargeIn--;

	        w = entry;

	        if (enlargeIn == 0) {
	          enlargeIn = powerOf2(numBits);
	          numBits++;
	        }

	      }	
    }
    private static int powerOf2(int power) {
	    return 1 << power;
    }
    public static String f(int i) {
		return String.valueOf((char) i);
	}
    private static abstract class DecompressFunctionWrapper {
		public abstract char doFunc(int i);
    }
    
    protected static class DecData {
		public char val;
		public int position;
		public int index;		
    }
}
