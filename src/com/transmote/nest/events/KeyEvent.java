/*
 * This file is part of Nest.
 * Nest - http://transmote.com/nest/ is a
 * derivative of Processing - http://processing.org/ 
 * Copyright (C) 2011, Eric Socolofsky
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.transmote.nest.events;

/**
 * <p>
 * KeyEvent instances represent events dispatched by the Nest framework,
 * which wrap the processing.event.Event instances generated by Processing. 
 * </p>
 * 
 * @author		Eric Socolofsky
 * @see			Event
 * @see			EventDispatcher
 */
public class KeyEvent extends Event {
	public static final int KEY_PRESSED = processing.event.KeyEvent.PRESS;
	public static final int KEY_RELEASED = processing.event.KeyEvent.RELEASE;
	public static final int KEY_TYPED = processing.event.KeyEvent.TYPE;
	
	private processing.event.KeyEvent pKeyEvent;

	
	/**
	 * A Nest key event instance,
	 * generated automatically by the Nest framework.
	 * 
	 * @param	pEvent		This KeyEvent instance will wrap a
	 * 						processing.event.KeyEvent, passed in from PApplet.
	 */
	public KeyEvent (processing.event.KeyEvent pEvent) {
		super(pEvent.getAction());
		this.pEvent = pEvent;
		this.pKeyEvent = pEvent;
	}
	
	/**
	 * A Nest key event instance.
	 * 
	 * @param	type	The event type.  Equivalent to processing.event.KeyEvent.getAction().
	 */
	public KeyEvent (int type) {
		super(type);
	}
	
	/**
	 * The processing.event.KeyEvent instance generated by Processing,
	 * if applicable (if this KeyEvent instance was generated
	 * in response to a keyboard action captured and processed by PApplet).
	 */
	public processing.event.KeyEvent pKeyEvent () {
		return pKeyEvent;
	}
	
	//-----<PROCESSING API>------------------------------------------//
	public char getKey () {
		return pKeyEvent.getKey();
	}
	
	public int getKeyCode () {
		return pKeyEvent.getKeyCode();
	}
	//-----</PROCESSING API>-----------------------------------------//
	
	@Deprecated
	public int keyCode () {
		return pKeyEvent.getKeyCode();
	}
}