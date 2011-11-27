/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package cc.kune.selenium.spaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cc.kune.selenium.PageObject;

public class HomeSpacePageObject extends PageObject {

  @FindBy(xpath = "//div[@id='k-home-group-stats']/div/div[2]/div/div/div/img")
  private WebElement fstStats;
  @FindBy(xpath = "//div[@id='k-home-group-stats']/div/div[2]/div/div[2]/div/img")
  private WebElement sndStats;
  @FindBy(xpath = "//div[@id='k-home-group-stats']/div/div[2]/div/div[3]/div/img")
  private WebElement trdStats;

  public HomeSpacePageObject() {
  }

  public WebElement getFstStats() {
    return fstStats;
  }

  public WebElement getSndStats() {
    return sndStats;
  }

  public WebElement getTrdStats() {
    return trdStats;
  }

}