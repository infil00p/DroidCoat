#include <Wire.h>

#include <Max3421e.h>
#include <Usb.h>
#include <AndroidAccessory.h>

#define  LED1_RED       10
#define  LED1_GREEN     9
#define  LED1_BLUE      11
#define  FADESPEED      5

AndroidAccessory acc("Google, Inc.",
		     "DroidCoat",
                     "DemoKit Arduino Board",
		     "1.0",
		     "http://www.android.com",
		     "0000000012345678");

void setup();
void loop();

void init_leds()
{
	digitalWrite(LED1_RED, 1);
	digitalWrite(LED1_GREEN, 1);
	digitalWrite(LED1_BLUE, 1);

	pinMode(LED1_RED, OUTPUT);
	pinMode(LED1_GREEN, OUTPUT);
	pinMode(LED1_BLUE, OUTPUT);

}

byte b1, b2, b3, b4, c;
void setup()
{
	Serial.begin(115200);
	Serial.print("\r\nStart");

	init_leds();

	acc.powerOn();
}

void loop()
{
	byte err;
	byte idle;
	static byte count = 0;
	byte msg[3];
	long touchcount;

	if (acc.isConnected()) {
		int len = acc.read(msg, sizeof(msg), 1);
		int i;
		byte b;
		uint16_t val;
		int x, y;
		char c0;

		if (len > 0) {
			// assumes only one command per packet
			if (msg[0] == 0x2) {
				if (msg[1] == 0x0)
					analogWrite(LED1_RED, msg[2]);
				else if (msg[1] == 0x1)
					analogWrite(LED1_GREEN, msg[2]);
				else if (msg[1] == 0x2)
					analogWrite(LED1_BLUE, msg[2]);
			}
		}

		msg[0] = 0x1;
               delay(10);
	}
        /*
        else {
          int r, g, b;
          // fade from blue to violet
          for (r = 0; r < 256; r++) { 
            analogWrite(LED1_RED, r);
            delay(FADESPEED);
          } 
          // fade from violet to red
          for (b = 255; b > 0; b--) { 
            analogWrite(LED1_BLUE, b);
            delay(FADESPEED);
          } 
          // fade from red to yellow
          for (g = 0; g < 256; g++) { 
            analogWrite(LED1_GREEN, g);
            delay(FADESPEED);
          } 
          // fade from yellow to green
          for (r = 255; r > 0; r--) { 
            analogWrite(LED1_RED, r);
            delay(FADESPEED);
          } 
          // fade from green to teal
          for (b = 0; b < 256; b++) { 
            analogWrite(LED1_BLUE, b);
            delay(FADESPEED);
          } 
          // fade from teal to blue
          for (g = 255; g > 0; g--) { 
            analogWrite(LED1_GREEN, g);
            delay(FADESPEED);
          } 
	}
      */
}
