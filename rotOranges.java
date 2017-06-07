import java.util.*;
class Cell {
	int x;
	int y;
	public Cell(int x, int y){
		this.x=x;
		this.y=y;
	}
	public Cell(){
		this.x =0;
		this.y=0;
	}
	public String toString(){
		return "cell.x= "+this.x+" cell.y= "+this.y;
	}
}
public class rotOranges {
    private static boolean isValid(int[][] a, int i, int j){
    	return (i >= 0 && j >=0 && i < a.length && j < a[0].length);
    }
    private static boolean allRotten(int[][] a){
    	for(int i=0; i<a.length; i++){
    		for(int j=0; j<a[0].length;j++){
    			if(a[i][j] == 1)
    				return false;
    		}
    	}
    	return true;
    }
    private static boolean isDelim(Cell c){
    	return ((c.x == -1) && (c.y == -1) );
    }
    private static void print(Queue<Cell> qq){
    	for(Cell c: qq){
    		System.out.println(c);
    	}
    }
    public static int getRotTime(int[][] arr){
         Queue<Cell> queue = new ArrayDeque<>();
         Cell temp;
         int ans = 0;
         for(int i=0; i<arr.length; i++){
         	for(int j=0; j<arr[i].length; j++){
         		if(arr[i][j] == 2){
         			temp = new Cell();
         			temp.x = i;
         			temp.y = j;
         			queue.offer(temp);
         		}
         	}
         }
         temp = new Cell();
         temp.x=-1;
         temp.y=-1;
         queue.offer(temp);
         // System.out.println("This is the 1st point");
         // print(queue);
         while(!queue.isEmpty()){
         	boolean flag = false;
         	while(!isDelim(queue.peek())){
         		temp = queue.peek();
         		// System.out.println("This is the 2nd point");
         		// System.out.println(temp);
         		if(isValid(arr, temp.x+1, temp.y) && arr[temp.x+1][temp.y]==1){
         			if(!flag){
         				ans++;
         				flag=true;
         			}
         			arr[temp.x+1][temp.y]=2;
         			Cell newtemp = new Cell(temp.x+1, temp.y);
         			queue.offer(newtemp);
         			
         		}
         		if(isValid(arr,temp.x-1, temp.y) && arr[temp.x-1][temp.y]==1){
         			if(!flag){
         				ans++;
         				flag=true;
         			}
         			arr[temp.x-1][temp.y]=2;
         			Cell newtemp = new Cell(temp.x-1, temp.y);
         			queue.offer(newtemp);
         			
         		}
         		if(isValid(arr,temp.x, temp.y+1) && arr[temp.x][temp.y+1]==1){
         			if(!flag){
         				ans++;
         				flag=true;
         			}
         			arr[temp.x][temp.y+1]=2;
         			Cell newtemp = new Cell(temp.x, temp.y+1);
         			queue.offer(newtemp);
         			
         		}
         		if(isValid(arr,temp.x, temp.y-1) && arr[temp.x][temp.y-1]==1){
         			if(!flag){
         				ans++;
         				flag=true;
         			}
         			arr[temp.x][temp.y-1]=2;
         			Cell newtemp = new Cell(temp.x+1, temp.y-1);
         			queue.offer(newtemp);
         			
         		}
         		queue.poll();
         	}
         	queue.poll();
         	if(!queue.isEmpty()){
         		temp = new Cell();
         		temp.x=-1;
         		temp.y=-1;
         		queue.offer(temp);
         	}
         }
         return (allRotten(arr))?ans:-1;
    }
    public static void main(String[] args){
    	int[][] test1 = {{2,1,0,2,1},
                         {1,0,1,2,1},
                         {1,0,0,2,1}  };
        int ans = getRotTime(test1);
        System.out.println("The time to rot all of the test1 is "+ ans);
        int[][] test2 = { {2, 1, 0, 2, 1},
                          {0, 0, 1, 2, 1},
                          {1, 0, 0, 2, 1}};
        ans = getRotTime(test2);
        System.out.println("The time to rot all of the test2 is "+ ans);
    }
}