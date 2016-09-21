import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(printBinary(0.25));
		//int[] a={8,1,2,0,6,4,5,7};
		//System.out.println(findMissing(a));
		
		byte[] screen={0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
		for(byte b:screen){
			System.out.print(b+" ");
		}
		System.out.println();
		drawHorizontalLine(screen, 24, 6, 7, 1);
		//drawLine(screen, 24, 1, 21, 1);
		for(byte b:screen){
			System.out.print(b+" ");
		}
		
	}
	
	public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y){
		int byteW = width/8;
		int start=byteW*y+x1/8;
		int end=byteW*y+x2/8;
		
		for(int i=start+1;i<end;i++){
			screen[i]=(byte)0xFF;
		}
		
		byte start_mask=(byte) ((1<<(8-(x1%8)))-1);
		byte end_mask=(byte)(~((1<<(7-(x2%8)))-1));//draw all the brackets
		
		if(x1/8==x2/8){//check if they are in same byte
			byte mask=(byte) (start_mask & end_mask);
			screen[start] |= mask;	
		}else{
			screen[start] |= start_mask;
			screen[end] |= end_mask;
		}
	}
	
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
		int start_offset=x1%8;
		int first_full_byte=x1/8;
		if(start_offset!=0){
			first_full_byte++;
		}
		int end_offset=x2%8;
		int last_full_byte=x2/8;
		if(end_offset!=7)last_full_byte--;
		
		for(int b=first_full_byte;b<=last_full_byte;b++){//set full bytes
			screen[(width/8)*y+b]=(byte)0xff;
		}
		
		byte start_mask=(byte) (0xff>>start_offset);
		byte end_mask=(byte)~(0xff>>(end_offset+1));
		
		if((x1/8)==(x2/8)){//x1 and x2 are in the same byte
			byte mask=(byte)(start_mask & end_mask);
			screen[(width/8)*y+(x1/8)] |= mask;
		}else{
			if(start_offset!=0){
				int byte_number =(width/8)*y+first_full_byte-1;
				screen[byte_number] |= start_mask;
			}
			if(end_offset !=7){
				int byte_number=(width/8)*y+last_full_byte+1;
				screen[byte_number] |= end_mask;
			}
		}
	}



}
