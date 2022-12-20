package helpz;

public class LevelBuild {

	public static int[][] getLevelData() {

		// Creates a 2D int array
		// where every index is a tile on the level.

		int[][] lvl = {
                    { 0, 0, 0, 0, 0, 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 8},
                    { 0, 0, 0, 0, 0, 1, 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 0 , 0 , 8},
                    { 0, 0, 0, 0, 6, 2, 2 , 2 , 4 , 0, 0 , 0 , 0 , 0 , 1 , 1 , 1 , 0 , 0 , 8},
                    { 0, 0, 0, 1, 3, 0, 0 , 0 , 3 , 1 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 0 , 0 , 8},
                    { 0, 0, 0, 1, 3, 0, 0 , 0, 3 , 0 , 0 , 0 , 0 , 0 , 1 , 1, 1 , 0 , 0 , 8},
                    { 0, 0, 0, 0, 3, 0, 0 , 0 , 3 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 8},
                    { 0, 0, 0, 0, 3, 1, 1 , 0 , 3 , 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 8},
                    { 0, 0, 0, 1, 3, 1, 1 , 0 , 3 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 0, 0 , 8},
                    { 0, 0, 0, 1, 3, 0, 0 , 0, 3 , 1 , 0 , 0 , 0 , 0 , 0, 6 , 2 , 2 , 2 , 9},
                    { 0, 0, 0, 0, 3, 1, 0 , 0 , 3 , 1 , 0 , 0 , 0 , 0 , 0 , 3 , 0, 0 , 0, 8},
                    { 2, 2, 2, 2, 5, 0, 0, 0 , 3 , 0, 0 , 0 , 0 , 0 , 0 , 3 , 0 , 0 , 0 , 8},
                    { 0, 0, 0, 0, 0, 0, 0 , 0 , 3 , 0 , 0 , 0 , 0 , 0 , 0 , 3 , 0 , 0 , 0 , 8},
                    { 0, 0, 0, 0, 0, 0, 0 , 0 , 3 , 1 , 1 , 0, 0 , 0 , 0, 3 , 0 , 0 , 0 , 8},
                    { 0, 0, 0, 0, 0, 0, 0 , 0, 7 , 2 , 2 , 2 , 4 , 0 , 0 , 3 , 0 , 0 , 0 , 8},
                    { 0, 0, 1, 1, 1, 0, 0 , 0 , 0 , 0 , 0, 1 , 3 , 0, 0 , 3 , 0, 0 , 0 , 8},
                    { 0, 0, 1, 1, 1, 0, 0 , 0 , 0 , 0 , 0 , 0, 3 , 0 , 0 , 3 , 0 , 0 , 0 , 8},
                    { 0, 0, 1, 1, 1, 0, 0 , 0 , 0 , 0 , 0 , 0 , 3 , 0 , 0, 3 , 0 , 1 , 1 , 8},
                    { 0, 0, 1, 1, 1, 0, 0 , 0 , 0 , 0 , 0 , 0 , 7 , 2 , 2 , 5 , 0 , 1 , 1 , 8},
                    { 0, 0, 0, 0, 0, 0, 0 , 0 , 0 , 0 , 0 , 0 , 0, 0 , 0, 0 , 0 , 0 , 0 , 8},
                    { 0, 0, 0, 0, 0, 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 8},

		};
                
		return lvl;

	}
        public static int[][] getLevelDecoration(){
            int[][] arrayDecoration = {
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 4, 0, 0},
                    { 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},       
                };
            return arrayDecoration;
        }

}