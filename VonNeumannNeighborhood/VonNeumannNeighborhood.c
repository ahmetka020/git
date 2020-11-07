#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void printArr(int size,int *arr){
	int i,j;
	for (i = 0; i <  size; i++){
    	for (j = 0; j < size; j++){
    		printf("%d ", *(arr + i*size + j)); 
		} 
		printf("\n");
	}
	printf("\n"); 
}

void arrPaint(int size,int *arr,int pointx,int pointy,int count){
	*(arr + pointx*size + pointy) = 1;
	if(count != 1){
		count--;
		arrPaint(size,arr,pointx,pointy+1,count);
		arrPaint(size,arr,pointx+1,pointy,count);
		arrPaint(size,arr,pointx-1,pointy,count);
		arrPaint(size,arr,pointx,pointy-1,count);
	}
}

int main(int argc, char *argv[]) {
	int size,i,j,count=0,stepCount=0,startPoint=0;
	printf("Please give n:");
	scanf("%d",&size);
	stepCount = size + 1;
	size = (size + 1)*2 + 1;
	startPoint = size/2;
	
    int *arr = (int *)malloc(size * size * sizeof(int)); 
  

    for (i = 0; i <  size; i++) 
      for (j = 0; j < size; j++) 
         *(arr + i*size + j) = 0; 
  
	*(arr + startPoint*size + startPoint) = 1;
	while(stepCount > 0){
		arrPaint(size,arr,startPoint,startPoint,stepCount);
		stepCount --;
	}
	
	printArr(size,arr);
	 
	
	free(arr);
	return 0;
}





