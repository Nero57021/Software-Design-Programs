package game.ui;

import game.GameOfLife;
import game.preview.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class GameOfLifeGUI extends JPanel {
	
	private List<Position> liveCells;
	
	private GameOfLifeGUI(List<Position> signals) {
		
		liveCells = signals;
		init().start();
	}
	
	private static List<Position> readUserInput(String cells) {
		Pattern cp = Pattern.compile("(\\d+(?=,),(?<=,)\\d+)");
		Matcher matcher = cp.matcher(cells);
		
		return matcher.results()
			.map(coordinate -> {
				String xy = coordinate.group();
				int row = Integer.parseInt(xy.split(",")[0]);
				int col = Integer.parseInt(xy.split(",")[1]);
				return new Position(row, col);
			})
			.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		
		List<Position> userCustomCells = readUserInput(args.length > 0 ? args[0] : "");
		
		List<Position> cells = List.of(
			new Position(4, 3),
			new Position(2, 4),
			new Position(3, 2),
			new Position(4, 4),
			new Position(3, 3),
			new Position(5, 9),
			new Position(5, 8),
			new Position(5, 7),
			new Position(0, 1)
		);
		
		GameOfLifeGUI game = new GameOfLifeGUI(userCustomCells.isEmpty() ? cells : userCustomCells);
		JFrame frame = new JFrame();
		frame.setSize(900, 820);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private Timer init() {
		return new Timer(1000, e -> {
			repaint();
			liveCells = GameOfLife.nextGeneration(liveCells);
		});
	}
	
	private void makeGrid(Graphics graphics, int rows, int cols, int cellSpace) {
		
		graphics.setColor(Color.WHITE);
		for (int i = 0; i < rows + 7; i++) {
			for (int j = 0; j < cols + 7; j++) {
				graphics.drawRect(j * cellSpace, i * cellSpace, getWidth(), getHeight());
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		
		graphics.setColor(Color.GRAY);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		List<Position> bounds = GameOfLife.getBounds(liveCells);
		
		Position bottomRight = bounds.get(1);
		Position topLeft = bounds.get(0);
		
		int gridWidth = bottomRight.x() - topLeft.x() + 7;
		int gridHeight = bottomRight.y() - topLeft.y() + 7;
		
		int cellSpace = Math.min(getHeight() / (gridHeight), getWidth() / (gridWidth));
		
		graphics.setColor(Color.BLUE);
		for (Position cell : liveCells) {
			int row = (cell.x() - topLeft.x()) * cellSpace;
			int col = (cell.y() - topLeft.y()) * cellSpace;
			graphics.fillRect(row, col, cellSpace, cellSpace);
		}
		
		int gridSize = Math.max(gridHeight, gridWidth);
		makeGrid(graphics, gridSize, gridSize, cellSpace);
		
	}
}
