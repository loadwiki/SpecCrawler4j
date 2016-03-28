/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.uci.ics.crawler4j.examples.localdata;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Set;

public class CrawlStat {
  private int totalProcessedPages;
  private long totalLinks;
  private long totalTextSize;
  private ConcurrentHashMap<String,Integer>	typeCount = new ConcurrentHashMap<String,Integer>();
  
  public int getTotalProcessedPages() {
    return totalProcessedPages;
  }

  public void setTotalProcessedPages(int totalProcessedPages) {
    this.totalProcessedPages = totalProcessedPages;
  }

  public void incProcessedPages() {
    this.totalProcessedPages++;
  }

  public long getTotalLinks() {
    return totalLinks;
  }

  public void setTotalLinks(long totalLinks) {
    this.totalLinks = totalLinks;
  }

  public long getTotalTextSize() {
    return totalTextSize;
  }

  public void setTotalTextSize(long totalTextSize) {
    this.totalTextSize = totalTextSize;
  }

  public void incTotalLinks(int count) {
    this.totalLinks += count;
  }

  public void incTotalTextSize(int count) {
    this.totalTextSize += count;
  }
  
  public void incContentType(String pagetype)
  {
	  Integer count = typeCount.get(pagetype);
	  if(count != null)
		 typeCount.replace(pagetype, count, count + 1) ;
	  else
		  typeCount.put(pagetype,1);
  }
  public  Set<Map.Entry<String,Integer>> getTypeCount()
  {
	  return typeCount.entrySet();
  }
  
  
}