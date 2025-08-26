class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {

        double maxdiagonal=0;
        int maxarea=0;


        for(int i=0;i<dimensions.length;i++){
            int length= dimensions[i][0];
            int width=dimensions[i][1];

            double diagonal = Math.sqrt(length*length+width*width);
            int area = length*width;


            if(diagonal>maxdiagonal){
                maxdiagonal=diagonal;
                maxarea=area;

            }

            else if(diagonal==maxdiagonal && area>maxarea){
                maxarea=area;
            }
        }
        return maxarea;
        
    }
}