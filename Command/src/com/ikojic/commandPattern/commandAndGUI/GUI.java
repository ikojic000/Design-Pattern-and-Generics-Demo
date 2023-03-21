package com.ikojic.commandPattern.commandAndGUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ikojic.commandPattern.design.CustomTable;
import com.ikojic.commandPattern.design.ScrollBarCustom;


public class GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4339836054938396735L;
	private JPanel contentPane;
	private MenuBar menuBar;
	private ToolBar toolBar;
	private PopUpMenu popupMenu;
	private JScrollPane tableScrollPane;
	private CustomTable table;
	private CustomTableModel tableModel;
	private String[][] defaultTableData;
	private String[] defaultColumnNames;
	
//	*** 
	private Stack<DeleteCommand> undoStack = new Stack<DeleteCommand>();
	private Stack<DeleteCommand> redoStack = new Stack<DeleteCommand>();
	
	public GUI() {
		
		setTitle( "Command Table" );
		setSize( 1200 , 1000 );
		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		
		UIManager.put( "Menu.selectionBackground" , new Color( 61 , 154 , 226 ) );
		UIManager.put( "Menu.selectionForeground" , new Color( 244 , 244 , 249 ) );
		UIManager.put( "MenuItem.selectionBackground" , new Color( 61 , 154 , 226 ) );
		UIManager.put( "MenuItem.selectionForeground" , new Color( 244 , 244 , 249 ) );
		UIManager.put( "Menu.opaque" , false );
		
//		*** MENU ***
		menuBar = new MenuBar();
		
//		*** ContentPane with ToolBar and Table ***
		contentPane = new JPanel();
		contentPane.setBackground( new Color( 244 , 244 , 249 ) );
		contentPane.setBorder( new EmptyBorder( 5 , 5 , 5 , 5 ) );
		
//		*** TOOLBAR *** 
		toolBar = new ToolBar();
		
//		*** TABLE ***
		tableScrollPane = new JScrollPane();
		tableScrollPane.setBorder( new EmptyBorder( 0 , 0 , 0 , 0 ) );
		tableScrollPane.setVerticalScrollBar( new ScrollBarCustom( 50 ) );
		
		table = new CustomTable();
		
		table.setFillsViewportHeight( true );
		table.setShowHorizontalLines( false );
		table.setShowVerticalLines( false );
		table.setShowGrid( false );
		table.setDefaultEditor( Object.class , null );
		tableScrollPane.setViewportView( table );
		
		String columnNames[] = { "A" , "B" , "C" };
		
		String tableData[][] = { { "Red 0" , "Red 0" , "Red 0" } , { "Red 1" , "Red 1" , "Red 1" } ,
								 { "Red 2" , "Red 2" , "Red 2" } , { "Red 3" , "Red 3" , "Red 3" } ,
								 { "Red 4" , "Red 4" , "Red 4" } , { "Red 5" , "Red 5" , "Red 5" } ,
								 { "Red 6" , "Red 6" , "Red 6" } , { "Red 7" , "Red 7" , "Red 7" } ,
								 { "Red 8" , "Red 8" , "Red 8" } , { "Red 9" , "Red 9" , "Red 9" } };
		
		defaultColumnNames = columnNames;
		defaultTableData = tableData;
		
		tableModel = new CustomTableModel( tableData , columnNames );
		table.setModel( tableModel );
		
//		*** POPUP MENU ***
		popupMenu = new PopUpMenu();
		
//		***
//		***
//		***
		activateMenu();
//		***
		activateToolBar();
//		***
		activatePopUp();
//		***
		initLayout();
		activatePanel();
		
	}
	
	
	private void initLayout() {
		
		setJMenuBar( menuBar );
		setContentPane( contentPane );
		contentPane.setLayout( new BorderLayout( 5 , 5 ) );
		contentPane.add( toolBar , BorderLayout.NORTH );
		contentPane.add( tableScrollPane , BorderLayout.CENTER );
		
	}
	
	
	private void activateMenu() {
		
		menuBar.getExitMenuItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				System.exit( 0 );
				
			}
			
		} );
		
		menuBar.getOpenMenuItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				openAction();
				
			}
			
		} );
		
		menuBar.getSaveMenuItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				saveAction();
				
			}
			
		} );
		
		menuBar.getDeleteRowMenuItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				deleteRowAction();
				
			}
			
		} );
		
		menuBar.getDeleteColumnMenuItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				deleteColumnAction();
				
			}
			
		} );
		
		menuBar.getClearAllMenuItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				clearAllAction();
				
			}
			
		} );
		
		menuBar.getNewColumnMenuItem().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				
				newColumnAction();
				
			}
			
		} );
		
		menuBar.getUndoMenuItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				undoAction();
				
			}
			
		} );
		
		menuBar.getRedoMenuItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				redoAction();
				
			}
			
		} );
		
	}
	
	
	private void activateToolBar() {
		
		toolBar.getBtnOpen().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				openAction();
				
			}
			
		} );
		
		toolBar.getBtnSave().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				saveAction();
				
			}
			
		} );
		
		toolBar.getBtnDeleteRow().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				deleteRowAction();
				
			}
			
		} );
		
		toolBar.getBtnDeleteColumn().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				deleteColumnAction();
				
			}
			
		} );
		
		toolBar.getBtnClearAll().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				clearAllAction();
				
			}
			
		} );
		
		toolBar.getBtnNewColumn().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed( ActionEvent e ) {
				
				newColumnAction();
				
			}
			
		} );
		
		toolBar.getBtnUndo().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				undoAction();
				
			}
			
		} );
		
		toolBar.getBtnRedo().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				redoAction();
				
			}
			
		} );
		
	}
	
	
	private void activatePopUp() {
		
		popupMenu.getClearTablePopupItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				clearAllAction();
				
			}
			
		} );
		
		popupMenu.getImportPopItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				openAction();
				
			}
			
		} );
		
		popupMenu.getSavePopItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				saveAction();
				
			}
			
		} );
		
		popupMenu.getUndoPopItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				undoAction();
				
			}
			
		} );
		
		popupMenu.getRedoPopItem().addActionListener( new ActionListener() {
			
			public void actionPerformed( ActionEvent e ) {
				
				redoAction();
				
			}
			
		} );
		
	}
	
	
	private void activatePanel() {
		
		table.addMouseListener( new MouseAdapter() {
			
			@Override
			public void mouseReleased( MouseEvent e ) {
				
				if ( e.getButton() == MouseEvent.BUTTON3 ) {
					
					if ( e.isPopupTrigger() ) {
						
						popupMenu.show( e.getComponent() , e.getX() , e.getY() );
						
					}
					
				}
				
			}
			
		} );
		
	}
	
	
	private void openAction() {
		
		CSVCommand loadFromCSV = new LoadFromCSV( tableModel , openFile() );
		loadFromCSV.executeCSV();
		
	}
	
	
	private void saveAction() {
		
		CSVCommand saveToCSV = new SaveToCSV( tableModel , saveFile() );
		saveToCSV.executeCSV();
		
	}
	
	
	private void deleteRowAction() {
		
		DeleteCommand deleteRowCommand = new DeleteRowCommand( tableModel , table.getSelectedRow() ,
				tableModel.getRowData( table.getSelectedRow() ) );
		deleteRowCommand.executeDeleteCMD();
		undoStack.push( deleteRowCommand );
		
	}
	
	
	private void deleteColumnAction() {
		
		DeleteCommand deleteColumnCommand = new DeleteColumnCommand( tableModel , table.getSelectedColumn() ,
				tableModel.getColumnName( table.getSelectedColumn() ) ,
				tableModel.getColumnData( table.getSelectedColumn() ) );
		deleteColumnCommand.executeDeleteCMD();
		undoStack.push( deleteColumnCommand );
		
	}
	
	
	private void clearAllAction() {
		
//		DeleteCommand clearAllCommand = new ClearAllCommand( tableModel , tableModel.getColumnNames() ,
//				tableModel.getTableData() );
		
		DeleteCommand clearAllCommand = new ClearAllCommand( tableModel , defaultColumnNames , defaultTableData ,
				tableModel.getColumnNames() , tableModel.getTableData() );
		clearAllCommand.executeDeleteCMD();
		undoStack.push( clearAllCommand );
		
	}
	
	
	private void newColumnAction() {
		
		InsertNewColumn newColumnCommand = new InsertNewColumn( tableModel , table.getSelectedColumn() , "New Column" );
		newColumnCommand.executeDeleteCMD();
		undoStack.push( newColumnCommand );
		
	}
	
	
	private void undoAction() {
		
		if ( !undoStack.isEmpty() ) {
			
			DeleteCommand deleteCommand = undoStack.pop();
			deleteCommand.undoDeleteCMD();
			redoStack.push( deleteCommand );
			getUndoRedoStackInfo();
			
		}
		
	}
	
	
	private void redoAction() {
		
		if ( !redoStack.isEmpty() ) {
			
			DeleteCommand deleteCommand = redoStack.pop();
			deleteCommand.redoDeleteCMD();
			undoStack.add( deleteCommand );
			getUndoRedoStackInfo();
			
		}
		
	}
	
	
//	Metoda koja otvori JFileChooser za otvaranje CSV i vrati String putanje odabranog file-a
	private String openFile() {
		
		String dataFolderPath = getDataFolderPath();
		System.out.println( dataFolderPath );
		String path = null;
		
		JFileChooser fileChooser = new JFileChooser( dataFolderPath );
		
		FileNameExtensionFilter csvFilter = new FileNameExtensionFilter( "CSV files" , "csv" );
		fileChooser.setFileFilter( csvFilter );
		
		int selected = fileChooser.showOpenDialog( null );
		
		if ( selected == JFileChooser.APPROVE_OPTION ) {
			
			path = fileChooser.getSelectedFile().getAbsolutePath();
			tableModel.loadFromCSV( path );
			
			clearStack();
			
		}
		
		return path;
		
	}
	
	
//	Metoda koja otvori JFileChooser za spremanje CSV i vrati String putanje odabranog file-a
	private String saveFile() {
		
		String dataFolderPath = getDataFolderPath();
		
		String path = null;
		
		JFileChooser fileChooser = new JFileChooser( dataFolderPath );
		fileChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
		
		int selected = fileChooser.showSaveDialog( null );
		
		if ( selected == JFileChooser.APPROVE_OPTION ) {
			
			path = fileChooser.getSelectedFile().getAbsolutePath() + ".csv";
			
		}
		
		return path;
		
	}
	
	
//	Metoda koja vrati String putanje "Data" folder-a
	private String getDataFolderPath() {
		
		File rootFolder = new File( this.getClass().getResource( "/" ).getPath().toString() ).getParentFile();
		String dataFolderPath = rootFolder.getPath() + "/data";
		
		return dataFolderPath;
		
	}
	
	
//	Metoda koja obrise undo i redo stack i isprinta ih
	private void clearStack() {
		
		undoStack.clear();
		redoStack.clear();
		getUndoRedoStackInfo();
		
	}
	
	
//	Metoda koja printa stanje undoStack-a i redoStacka
	public void getUndoRedoStackInfo() {
		
		System.out.println( "<<<<<<<<<<<<< UNDO STACK >>>>>>>>>>>>>" );
		
		for ( DeleteCommand cmd : undoStack ) {
			
			System.out.println( cmd );
			
		}
		
		System.out.println( "<<<<<<<<<<<<< REDO STACK >>>>>>>>>>>>>" );
		
		for ( DeleteCommand cmd : redoStack ) {
			
			System.out.println( cmd );
			
		}
		
		System.out.println( "------------------------------------------------- \n" );
		
	}
	
}
