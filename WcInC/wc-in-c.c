#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int main(void)
{
	//get file 
   printf("File dictionary : ");
   char str[20]; 
   gets(str); 
   //printf("%s", str);
   const char *myfile = str;
   int bytes = 0;
   int words = 0;
   int newLine = 0;
   char buffer[1];
   int file = open(myfile,O_RDONLY);
   enum states { WHITESPACE, WORD };
   int state = WHITESPACE;
   int MAX = 0;
   int maxCount = 0;
    
   //file "wc" operations.
   if(file == -1){
      printf("can not find :%s\n",myfile);
   }
   else{
      char last = ' '; 
      while (read(file,buffer,1) ==1 )
      {
         bytes++;

         if ( buffer[0]== ' ' || buffer[0] == '\t'  )
         {
            state = WHITESPACE;
         }
         else if (buffer[0]=='\n')
         {
         	if (maxCount > MAX){
         		MAX = maxCount; 
			}
         	maxCount = 0;
            newLine++;
            state = WHITESPACE;
         }
         else 
         {
            if ( state == WHITESPACE )
            {
               maxCount++;
               words++;
            }
            state = WORD;
         }
         last = buffer[0];
      }        
      printf("New lines: %d  Words : %d Bytes : %d\n",newLine,words,bytes);  
	  printf("Max word count in a line : %d",MAX);      
   } 

}
