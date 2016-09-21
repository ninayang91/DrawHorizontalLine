# DrawHorizontalLine
Draw a horizontal line in an array

public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y)

byte[] screen={0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00};

drawHorizontalLine(screen, 24, 1, 21, 1);

1 byte=8 bits = 2 hex

find start and end index, fill screen [start+1] ~ screen[end-1] with 0xFF;

write a start_mask=0111 1111 and end_mask=1111 1100

if x1 and x2 are in the same byte, mask=start_mask & end_mask



