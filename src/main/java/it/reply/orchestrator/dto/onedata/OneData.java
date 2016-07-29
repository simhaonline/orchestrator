package it.reply.orchestrator.dto.onedata;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class OneData implements Serializable {

  private static final long serialVersionUID = 8590316308119399053L;

  private String token;
  private String space;
  private String path;
  private String zone;
  private List<String> providers;

  /**
   * Construct OneData settings with providers as CSV.
   * 
   * @param token
   *          .
   * @param space
   *          .
   * @param path
   *          .
   * @param providers
   *          .
   * @param zone
   *          The zone
   */
  public OneData(String token, String space, String path, String providers, String zone) {
    super();
    this.token = token;
    this.space = space;
    this.path = path;
    this.zone = zone;
    this.providers = (providers != null ? Arrays.asList(providers.split(",")) : null);
  }

  public OneData(String token, String space, String path, String providers) {
    this(token, space, path, providers, null);
  }

  /**
   * Construct OneData settings with providers as list.
   * 
   * @param token
   *          .
   * @param space
   *          .
   * @param path
   *          .
   * @param providers
   *          .
   */
  public OneData(String token, String space, String path, List<String> providers, String zone) {
    super();
    this.token = token;
    this.space = space;
    this.path = path;
    this.zone = zone;
    this.providers = providers;
  }

  public OneData(String token, String space, String path, List<String> providers) {
    this(token, space, path, providers, null);
  }

  public String getToken() {
    return token;
  }

  public String getSpace() {
    return space;
  }

  public String getPath() {
    return path;
  }

  public String getZone() {
    return zone;
  }

  public List<String> getProviders() {
    return providers;
  }

  /**
   * Generate the provider list as CSV.
   * 
   * @return the provider list as CSV
   */
  public String getProvidersAsList() {
    return providers != null ? StringUtils.join(providers, ",") : "";
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
